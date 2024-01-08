import { GoogleLogin } from '@react-oauth/google';
import { GoogleOAuthProvider } from '@react-oauth/google';

const GoogleLoginButton = () => {
    const clientId =
        '604762789051-83udmss7laf2318g8sck2okamo3tl8d5.apps.googleusercontent.com';



        //reder prop : 사용자가 버튼을 클릭하는 것을 나타내는 추가 구문
    return (
        <>
        <GoogleOAuthProvider clientId={clientId}>
            <GoogleLogin
            onSuccess={(res) => {
                console.log(res);
            }}
            onFailure={(err) => {
                console.log(err);
            }}
            />
        </GoogleOAuthProvider>
        </>
    );
    };

export default GoogleLoginButton;