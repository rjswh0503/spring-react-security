
import React, {useState, useEffect} from 'react';
import axios from 'axios';





function App() {

  const [data, setData] = useState([]);
  const [newUser, setNewUser] = useState({username:'', email:''});


 

  /*
    fetchData라는 이름을 정의해서  try-catch문을 사용해 비동기 작업 중 발생하는 에러를 잡아내고 콘솔에 메세지를 출력하는 것
    간접적으로 호출 
    
    useEffect안에서 직접 비동기 작업을 수행
    간단하게 catch문을 사용해서 애러를 처리하고 콘솔에 애러 메세지를 출력
  */ 
  useEffect(() => {
    const fetchData = async() => {
      try{
        const res = await axios.get('http://localhost:8080/api/users', {
          withCredentials:true, 
        });
        setData(res.data);
      }catch(error){
        console.log(error);

      };
    };
    fetchData();
  }, []);

//전송하는 버튼 함수 추가




//데이터 작성한내용으로 변경하는 함수
const handleInputChange = (e) => {
  /*
    


  */ 
  const {name, value} = e.target;
  setNewUser((prevUser) => ({...prevUser, [name] : value}));
};





//데이터 보내줄 post 추가
const handleAddUser = async () => {
  try {
    const response = await axios.post(
  'http://localhost:8080/api/users',newUser,{withCredentials:true, 

});
  //변경된 데이터 값 저장
  setData((prevUser) => [...prevUser, response.data]);

  //데이터 저장되고 나서 빈값으로 초기화 하길 원한다면 초기화도 진행
  setNewUser({username:'', email: ''});

    } catch(error) {
      console.error('데이터가 부적합합니다.',error);
    }
}
  

  /*
  useEffect(() => {
    axios
    .get('http://localhost:8080/api/greet', {withCredentials:true})
    //response = res : 같은 의미이며, 안에 변수값은 정해진 변수 값은 없지만 되도록이면 res response를 사용하면 좋음
    .then((res) => {
      setData(res.data);
    })
    .catch((error) => {
      console.log('데이터없음',error);
    });
  }, []);
  */

  return (
    
    <div>
      <h1>User List</h1>
      <table border={1}>
        <thead>
          <tr>
            <th>name</th>
            <th>email</th>
          </tr>
        </thead>
        {data.map((user) => (
          <tbody>
            <tr key={user.id}>
              <td>{user.username}</td>
              <td>{user.email}</td>
          </tr>
          </tbody>
          
        ))}
      </table>
      

      

      <h2>새로운 유저 저장</h2>
      <div>
        <label>회원 이름 : </label>
          <input type='text'
          name='username'
          value={newUser.username}
          onChange={handleInputChange}/><br/>
        <label>이메일 : </label>
          <input type='text'
          name='email'
          value={newUser.email}
          onChange={handleInputChange}/>   
      </div>
      <button onClick={handleAddUser}>유저 저장</button>
      
    </div>
  
    
  )
}

export default App;
