import { useState } from 'react';

function Formregistro(props) {
  const [datosFormulario, setDatosFormulario] = useState(props.datos);

  const handleSubmit = (event) => {
    event.preventDefault();
    props.onFormSubmit(datosFormulario);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setDatosFormulario((datosAnteriores) => ({
      ...datosAnteriores,
      [name]: value,
    }));
  };


  return (
    <form onSubmit={handleSubmit}>
      <div>
          <label htmlFor="name">Nombre:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={datosFormulario.nombre}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="lastName">Apellidos:</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={datosFormulario.lastName}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="username">Nombre de usuario:</label>
          <input
            type="text"
            id="username"
            name="username"
            value={datosFormulario.username}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="email">Correo electrónico:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={datosFormulario.email}
            onChange={handleInputChange}
          />
        </div>
        <div>
            <label htmlFor="password">Contraseña:</label>
            <input 
            type="password" 
            name="contrasena" 
            value={datosFormulario.contrasena} 
            onChange={handleInputChange} />
        </div>
        <div>
          <label htmlFor="phoneNumber">Número de teléfono:</label>
          <input
            type="tel"
            id="phoneNumber"
            name="phoneNumber"
            value={datosFormulario.telefono}
            onChange={handleInputChange}
          />
        </div>
      <button type="submit" >Registrarme</button>
    </form>
  );
}

export default Formregistro;