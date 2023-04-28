import React, { useState } from "react";
import { Link } from "react-router-dom";
import './App.css';

function DoorForm(props) {
  const [datospuerta, setDatospuerta] = useState(props.newpuerta);

  const handleSubmit = (event) => {
    event.preventDefault();
    props.onFormSubmit(datospuerta);
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setDatospuerta({
      ...datospuerta,
      [name]: value,
    });
  };

  return (
    <div class='formDiv'>
      <div class="pollo">
        <label htmlFor="id">Numero de registro de puerta:</label>
        <input class="inputs"
          
          type="text"
          id="id"
          name="id"
          value={datospuerta.id}
          onChange={handleChange}
        />
      </div>
      <div class="pollo">
        <label htmlFor="ubicacion">Ubicacion:</label>
        <input class="inputs"
          type="text"
          id="ubicacion"
          name="ubicacion"
          value={datospuerta.ubicacion}
          onChange={handleChange}
        />
      </div>
      <button class="botonLog" onClick={handleSubmit} type="submit">RegistrarPuerta</button>
      <Link to="/"><button class="botonLog">Volver</button></Link>
    </div>
  );
}
export default DoorForm;
