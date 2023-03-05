import React, { useState } from "react";
import { Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Principal from './Principal.js'
import {Route, Routes} from "react-router-dom";
import NoMatch from "./NoMatch.js";
import Header from "./Header.js";
import DoorForm from "./DoorForm";
import AdminForm from "./AdminForm.js";
import Formlogin from "./Formlogin";
import Registro from "./Registro.js";
import Formregistro from "./Formregistro.js";

function App() {
  //INICIO DE SESION / REGISTRO
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [showRegistro, setShowRegistro] = useState(false)
  const [datos, setDatos] = useState({
    name: "",
    lastName: "",
    username: "",
    email: "",
    password: "",
    phoneNumber: ""
  });

  const handleFormSubmit = (nuevosDatos) => {
    setDatos(nuevosDatos);
    let auxlogin = isLoggedIn
    let auxRegistrado = showRegistro
    setIsLoggedIn(!auxlogin);
    setShowRegistro(!auxRegistrado)
  };

  const handleLoginform = (nuevosDatos) => {
    setDatos(nuevosDatos);
    let auxlogin = isLoggedIn;
    setIsLoggedIn(!auxlogin);
  };

  const handleRegistro = () => {
    let auxregistro = showRegistro
    setShowRegistro(!auxregistro);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  //ADMIN
  const [adminusername, setAdminusername] = useState();

  //PUERTAS
  const [puertas, setPuertas] = useState([]);
  const [newpuerta, setNewpuerta] = useState({
    id: "",
    ubicacion: "",
  })

  const agregarPuerta = (newpuerta) => {
    let puertasantiguas = puertas
    setPuertas([...puertasantiguas, newpuerta]);  
  };

  return(
    <div>
    {isLoggedIn ? (
    <div>
   <Header/>
  <Routes>
      <Route path="/" element={<Principal puertas={puertas} datos={datos} handleLogout={handleLogout}/>}/>
      <Route path="/adminform" element={<AdminForm adminusername={adminusername} onFormSubmit={setAdminusername}  />}/>
      <Route path="/doorform" element={<DoorForm onFormSubmit={agregarPuerta} newpuerta={newpuerta}/>}/>
      <Route path="/registroform" element={<Registro/>}/>
      <Route path="*" element={<NoMatch/>}/>
    </Routes> 
   </div>
   ) : (
    <div>
    {!showRegistro ? (
      <div>
        <Formlogin onFormSubmit={handleLoginform} datos={datos}/>
      <p>
        ¿No tienes cuenta? <a href="#" onClick={handleRegistro}>Regístrate</a>
      </p>
    </div>
    ) : (
      <div>
        <Formregistro onFormSubmit={handleFormSubmit} datos={datos}/>
      </div>
      )}
   </div>
  )}
  </div>
  );
}

export default App;
