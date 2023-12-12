import './App.css';
import "./style.scss"
import Registration from "./pages/Registration"
import Login from './pages/Login';
import Home from './pages/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Login/>}></Route>
        <Route path='/register' element={<Registration/>}></Route>
        <Route path='/chat' element={<Home/>}></Route>
      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
