import React, { useState } from "react";
import { Link } from "react-router-dom";

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
    <div>
      <div>
        <label htmlFor="id">Numero de registro de puerta:</label>
        <input
          type="text"
          id="id"
          name="id"
          value={datospuerta.id}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="ubicacion">Ubicacion:</label>
        <input
          type="text"
          id="ubicacion"
          name="ubicacion"
          value={datospuerta.ubicacion}
          onChange={handleChange}
        />
      </div>
      <button onClick={handleSubmit} type="submit">RegistrarPuerta</button>
      <Link to="/"><button>Volver</button></Link>
    </div>
  );
}
export default DoorForm;
