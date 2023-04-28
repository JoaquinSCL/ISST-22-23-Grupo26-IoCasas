import { useState } from "react";
import DatePicker from "react-datepicker";
import TimePicker from 'rc-time-picker';
import { Link } from "react-router-dom";
import moment from 'moment';
import 'rc-time-picker/assets/index.css';
import 'react-datepicker/dist/react-datepicker.css';
import './App.css';


function Registro(){
const [fechain, setFechain] = useState(new Date());
const [horain, setHorain] = useState(null);
const [fechaout, setFechaout] = useState(new Date());
const [horaout, setHoraout] = useState(null);
const [nombreUsuario, setNombreUsuario] = useState("");

const handleFechaChangein = (fecha) => {
    setFechain(fecha);
  };

  const handleHoraChangein = (hora) => {    
    setHorain(hora);
  };
  const handleFechaChangeout = (fecha) => {
    setFechaout(fecha);
  };

  const handleHoraChangeout = (hora) => {
    setHoraout(hora);
  };
  

  const handleSubmit = (event) => {
    event.preventDefault();
};
return(
    <div class='product-box'>
    <div>
        <label htmlFor="username">Nombre de usuario:</label>
        <input class='inputs'
        type="text"
        id="username"
        name="username"
        value={nombreUsuario}
        onChange={(e) => setNombreUsuario(e.target.value)}
          />
        </div>
    <form onSubmit={handleSubmit}>
      <div class='formDiv'>
        <label>Fecha entrada:</label>
        <DatePicker 
        selected={fechain} 
        onChange={handleFechaChangein} />
      </div>
      <div class='formDiv'>
        <label>Hora entrada:</label>
        <TimePicker 
        value={horain} 
        onChange={handleHoraChangein} 
        showSecond={false} />
      </div>
      <div class='formDiv'>
        <label>Fecha salida:</label>
        <DatePicker 
        selected={fechaout} 
        onChange={handleFechaChangeout} />
      </div>
      <div class='formDiv'>
        <label>Hora salida:</label>
        <TimePicker 
        value={horaout} 
        onChange={handleHoraChangeout} 
        showSecond={false} />
      </div>
      <button class='botonLog' type="submit">Enviar</button>
    </form>
    <Link to="/"><button class='botonLog'>Volver</button></Link>
    </div>
)
}
export default Registro;