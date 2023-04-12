import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Table } from 'react-bootstrap';
import axios from 'axios';

function Principal(props){
  const [showDropdown, setShowDropdown] = useState(false);
  // Función para agregar una nueva puerta al array 
  const [key, setKey] = useState(null);

  const handleUsernameClick = () => {
    setShowDropdown(!showDropdown);
  };

  

  // Función para obtener el valor de la key
  const getAccessCode = async (idReserva, emailInquilino) => {
    try {
      const response = await axios.get(`/api/${idReserva}/acceso?emailInquilino=${emailInquilino}`);
      setKey(response.data);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  }


return (
  <div className="App">
      <div className="header-container">
        <h1>Bienvenido, <a href="#" onClick={handleUsernameClick}>{props.datos.username}</a></h1>
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
              <td>{reserva.idReserva}</td>
              <td>{new Date(reserva.entrada).toLocaleString()}</td>
              <td>{new Date(reserva.salida).toLocaleString()}</td>
              <td><button onClick={() => getAccessCode(reserva.idReserva, props.datos.email)}>Obtener acceso</button></td>
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

