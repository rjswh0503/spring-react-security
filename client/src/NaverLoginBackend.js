//NaverLoginButton.js
import React from 'react';
import axios from 'axios';

export default function NaverLoginButton() {
    const handleNaverLogin = async () => {
        try {
        const response = await axios.get(
            //spring.security.oauth2.client.registration.naver.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}
            'http://localhost:8080/login/oauth2/code/naver',
            // 'http://localhost:8080/oauth2/authorization/naver',
            { withCredentials: true }
        );
        console.log('FrontEnd에서 제공되는 콘솔 로그 ');
        console.log(response.data);
        } catch (error) {
        console.error('Naver login error : ', error);
        }
    };
    return (
        <div>
        <button onClick={handleNaverLogin}>Naver Login</button>
        </div>
    );
}