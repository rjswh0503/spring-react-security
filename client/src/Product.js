import React, {useState, useEffect} from 'react';
import axios from 'axios';
import AddProduct from './AddProduct';


function Product() {

    const [data, setData] = useState([]);
    const [newProduct, setNewProduct] = useState({name:'', price:''});




    useEffect (() => {
        const fetchData = async() => {
            try {
                const res = await axios.get('http://localhost:8081/api/item', {
                    withCredentials:true,
                });
                setData(res.data);
            }catch(error){
                console.log(error);
            };
        };
        fetchData();
    }, []);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setNewProduct((prevProduct) => ({...prevProduct, [name] : value}));

    };


    const handleAddProduct = async () => {
        try{
            const response = await axios.post(
                'http://localhost:8081/api/add', newProduct, {withCredentials:true,

            });

            setData((prevProduct) => [...prevProduct, response.data]);

            setNewProduct({name:'', price:''});


            
        } catch(error) {
            console.error('데이터가 부적합합니다.', error);
        }
    }



    return (
        <div>
            <h1>Product List</h1>
            <table border={1}>
                <thead>
                    <tr>
                        <th>name</th>
                        <th>price</th>
                    </tr>
                </thead>
                {data.map((Product) => (
                    <tbody>
                        <tr key={Product.id}>
                            <td>{Product.name}</td>
                            <td>{Product.price}원</td>
                        </tr>
                    </tbody>
                ))}
                
            </table>
            <AddProduct/>
        </div>
        

    )

}

export default Product;