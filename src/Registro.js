import { useState } from "react";
import DatePicker from "react-datepicker";
import TimePicker from 'rc-time-picker';
import { Link } from "react-router-dom";
import moment from 'moment';
import 'rc-time-picker/assets/index.css';
import 'react-datepicker/dist/react-datepicker.css';


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
    <div>
    <div>
        <label htmlFor="username">Nombre de usuario:</label>
        <input
        type="text"
        id="username"
        name="username"
        value={nombreUsuario}
        onChange={(e) => setNombreUsuario(e.target.value)}
          />
        </div>
    <form onSubmit={handleSubmit}>
      <div>
        <label>Fecha entrada:</label>
        <DatePicker 
        selected={fechain} 
        onChange={handleFechaChangein} />
      </div>
      <div>
        <label>Hora entrada:</label>
        <TimePicker 
        value={horain} 
        onChange={handleHoraChangein} 
        showSecond={false} />
      </div>
      <div>
        <label>Fecha salida:</label>
        <DatePicker 
        selected={fechaout} 
        onChange={handleFechaChangeout} />
      </div>
      <div>
        <label>Hora salida:</label>
        <TimePicker 
        value={horaout} 
        onChange={handleHoraChangeout} 
        showSecond={false} />
      </div>
      <button type="submit">Enviar</button>
    </form>
    <Link to="/"><button>volver</button></Link>
    </div>
)
}
export default Registro;