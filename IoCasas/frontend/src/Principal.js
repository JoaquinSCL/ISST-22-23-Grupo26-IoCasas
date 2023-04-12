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
            <Link to="/adminform"><button>Hacer administrador</button></Link>
        </div>
          <div>
        <h3>Lista de reservas</h3>
        <Table>
          <tbody>
          {props.reservas.map((reserva) => (
            <tr key={reserva.idReserva}>
              <td>{reserva.ididReserva}</td>
              <td>{reserva.entrada}</td>
              <td>{reserva.salida}</td>
              <td><Link to="/registroform"><button > agregar inquilino</button></Link></td>
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
