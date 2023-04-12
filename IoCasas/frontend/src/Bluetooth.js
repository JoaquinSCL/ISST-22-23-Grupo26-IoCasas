import React, { useState } from "react";
import { TextEncoder } from 'util';

 function Bluetooth() {
  
  const [device, setDevice] = useState(null);
  
  
  const handleClick = async () => {
    try {
      const device = await navigator.bluetooth.requestDevice({
        acceptAllDevices: true,
        optionalServices: ['battery_service'] // Required to access service later.
      })
      setDevice(device);
      console.log("Device:", device.name);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const sendMessage = async () => {
  const message = new TextEncoder().encode("Hola"); 
  const  service = await device.gatt.getPrimaryService("custom_service");
  const characteristic = await service.getCharacteristic("custom_characteristic"); 
  await characteristic.send(message);
  try {
    if (characteristic) {
        const message = new TextEncoder().encode('Hola');
        await characteristic.writeValue(message);
        alert('Mensaje enviado');
    } else {
        alert('No hay una característica válida');
    }
} catch (error) {
console.error(error);
}
}

  return (
         <div className="bluetooth-component">
           <button onClick={handleClick}>Connect</button>
           {device && <p>Connected to {device.name}</p>}
         </div>
       );
}



export default Bluetooth;

// import React, { useState } from "react";
// import * as Bt from 'react-bluetooth';



// function Bluetooth() {

//   const [device, setDevice] = useState(null);
  
//   const handleClick = async () => {
//     try {
//       const result = await Bt.requestDeviceAsync();

//       if (result.type === 'cancel') {
//         return;
//       }

//      setDevice(result.device)
//     } catch ({ message, code }) {
//       console.log('Error:', message, code);
//     }

//   }

//   return (
//     <div className="bluetooth-component">
//       <button onClick={handleClick}>Connect</button>
//       {device && <p>Connected to {device.name}</p>}
//     </div>
//   );
// }

// export default Bluetooth