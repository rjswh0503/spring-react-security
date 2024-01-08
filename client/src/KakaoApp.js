import React from 'react';
import KakaoLogin from 'react-kakao-login';
import KakaoLoginImg from './image/kakao_login_large_narrow.png';




const KakaoApp = () => {
    const KakaoLoginSuccess = (res) => {
        console.log(res);
    }

    const KakaoLoginFailure = (err) => {
        console.error(err);
    }

    return (
        <>
            <KakaoLogin 
            token='40db0127c55d24537afa4e8e664d6f34'
            onSuccess={KakaoLoginSuccess}
            onFailure={KakaoLoginFailure}
            //getProfile={true}
            render ={(props) => (
                <img src='{KakaoLoginImg}'></img>

                
            )} 
            />
        </>
    );
};


export default KakaoApp;