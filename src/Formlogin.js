import { useState } from 'react';

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
            <h1>Inicio de Sesión</h1>
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
                <label htmlFor="password">Contraseña:</label>
                <input 
                    type="password" 
                    name="contrasena" 
                    value={datosFormulario.contrasena} 
                    onChange={handleInputChange} />
            </div>
            <button type="submit" >Login</button>
        </form>
    );
}
    export default Formlogin;