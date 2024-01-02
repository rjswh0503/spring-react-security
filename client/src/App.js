import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import AddProduct from './AddProduct';




const App = () => {
  const [products, setProducts] = useState([]);
  const [newProduct, setNewProduct] = useState({ name: '', price: '' });
  const [editingProduct, setEditingProduct] = useState(null);
  const [isEditing, setIsEditing] = useState(false);
  useEffect(() => {
    axios
      .get('http://localhost:8081/api/item')
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error(':', error);
      });
  }, []);
  const handleAddProduct = () => {
    axios
      .post('http://localhost:8081/api/add', newProduct)
      .then((response) => {
        setProducts((prevProducts) => [...prevProducts, response.data]);
        setNewProduct({ name: '', price: '', description:'' });
      })
      .catch((error) => {
        console.error('추가 에러:', error);
      });
  };
  const handleDeleteProduct = (id) => {
    axios
      .delete(`http://localhost:8081/api/delete/${id}`)
      .then((response) => {
        setProducts((prevProduct) =>
          //현재 목록에서 삭제할 제품을 제외하고
          //새로운 배열을 생성
          //삭제할 제품의 ID와 다른 제품들만 필터로 남겨주겠다
          //해주는 것
          prevProduct.filter((product) => product.id !== id)
        );
      })
      .catch((error) => {
        console.error('error', error);
      });
  };



  const handleEditProduct = (product) => {
    setEditingProduct(products);
    setNewProduct({name:product.name, price:product.price});
    setIsEditing(true);
  };

  //handleUpdateProduct

  const handleUpdateProduct = () => {
    axios
    .put(`http://localhost:8081/api/update/${editingProduct.id}`);
    newProduct

    .then((response) => {
      setProducts((prevProducts.map((product)=> {
        if(product.id === editingProduct.id) {
          return product;
        }
      })))
    })
  }


  return (
    <Router>
      <div>
        <h1>상품 리스트</h1>
        <table border={1}>
                <thead>
                    <tr>
                        <th>name</th>
                        <th>price</th>
                        <th>삭제</th>
                        <th>수정</th>
                    </tr>
                </thead>
                {products.map((product) => (
                    <tbody>
                        <tr key={product.id}>
                            <td>{product.name}</td>
                            <td>{product.price}</td>
                            <td><button onClick={() => handleEditProduct(product.id)}>수정</button></td>
                            <td><button onClick={() => handleDeleteProduct(product.id)}>삭제</button></td>
                        </tr>
                    </tbody>
                ))}
            </table>
      </div>
      <Routes>
        <Route
          path="/add"
          element={<AddProduct onAddProduct={handleAddProduct} />}
        />
        <Route path="/item">
        </Route>
      </Routes>
    </Router>
  );
}
export default App;