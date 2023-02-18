import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes,Route } from 'react-router-dom';
import AddUser from './Users/AddUser';
import EditUser from './Users/EditUser';
function App() {
  return (
    <div className="App">
        <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />}></Route>
          <Route exact path="/adduser" element={<AddUser/> } />
          <Route exact path="/edituser/:id" element={<EditUser/>} />
        
        </Routes>
        {/* <Home />  to show home table*/}
        </Router>
    </div>
  );
}

export default App;
