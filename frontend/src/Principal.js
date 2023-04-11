import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Table } from 'react-bootstrap';


function Principal(props){
  const [showDropdown, setShowDropdown] = useState(false);
  const [datos, setDatos] = useState(props.datos);
  // Función para agregar una nueva puerta al array 
  

  const handleUsernameClick = () => {
    setShowDropdown(!showDropdown);
  };



return (
  <div className="App">
      <div className="header-container">
        <h1>Bienvenido, <a href="#" onClick={handleUsernameClick}>{datos.username}</a></h1>
          {showDropdown && (
            <div className="dropdown">
            <button onClick={props.handleLogout}>Cerrar sesión</button>
            <button>Cambiar datos</button>
            </div>
          )}
      </div>

      <main>
        <div>
          <Link to="/doorform"><button>Registrar Puerta</button></Link>
        </div>
        <div>
          <button>Abrir puerta</button>
        </div>
        <div>
            <Link to="/adminform"><button>Hacer administrador</button></Link>
        </div>
          <div>
        <h3>Lista de puertas</h3>
        <Table>
          <tbody>
          {props.puertas.map((puerta) => (
            <tr key={puerta.id}>
              <td>{puerta.ubicacion}</td>
              <td><Link to="/registroform"><button > agregar inquilino</button></Link></td>
              <td><Bluetooth><Bluetooth/></td>
            </tr>
          ))}
          </tbody>
        </Table>
        </div> 
      </main>
  </div>
);
}

export default Principal;
