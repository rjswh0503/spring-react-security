import { BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom';
import App from './App';
import Product from './Product';


function AppMain() {
    return (
        <Router>
            <div>
                <Link to="/app">user</Link><br/>
                <Link to="/product">product</Link>
                <Routes>
                    <Route path='/app' element={<App/>}/>
                </Routes>
                <Routes>
                    <Route path='/product' element={<Product/>}/>
                </Routes>
            </div>
        </Router>
    )
}


export default AppMain;