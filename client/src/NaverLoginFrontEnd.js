import React from 'react';
import NaverLogin from 'react-naver-login';

//npm install react-naver-login
const NaverApp = () => {
  const clientId = '9KGwcqZCECNjODlab1WH';
  const NaverLoginSuccess = (response) => {
    console.log(response);
  };

  const NaverLoginFailure = (err) => {
    console.error(err);
  };

  return (
    <NaverLogin
    clientId={clientId}
      callbackUrl="http://localhost:3000/naverLogin"
      onSuccess={NaverLoginSuccess}
      onFailure={NaverLoginFailure}
      render={(props) => (
        <button onClick={props.onClick}>네이버로 로그인</button>
      )}
    />
  );
};

export default NaverApp;