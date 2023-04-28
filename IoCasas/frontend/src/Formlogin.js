import { useState } from 'react';
import './App.css';

function Formlogin(props) {
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
            <h1 id="tituloLogin">Inicio de Sesión</h1>
            <div class='formLogin'>
                <label htmlFor="username">Nombre de usuario:</label>
                <input
                    class="inputs"
                    type="text"
                    id="username"
                    name="username"
                    value={datosFormulario.username}
                    onChange={handleInputChange}
                />
            </div>
            <div class='formLogin'>
                <label htmlFor="password">Contraseña:</label>
                <input 
                    class="inputs"
                    type="password" 
                    name="contrasena" 
                    value={datosFormulario.contrasena} 
                    onChange={handleInputChange} />
            </div>
            <button class='botonLog' type="submit">Login</button>
        </form>
    );
}
    export default Formlogin;