function Bluetooth({ setDevice, setCharacteristic, setServer, setService }) {

    const connectToDevice = async () => {
        const device = await navigator.bluetooth
        .requestDevice({
            filters: [
                { namePrefix: "Device Name" },
                { services: [ 'Service ID' ]}
            ]
        })
        setDevice(device)
        const server = await device.gatt.connect()
        setServer(server)
        const service = await server.getPrimaryService('Service ID')
        setService(service)
        const characteristic = await service.getCharacteristic('Characteristic ID')
        setCharacteristic(characteristic)
        device.addEventListener('gattserverdisconnected', onDisconnected)
    }

    const onDisconnected = (event) => {
        alert("Vibrator Disconnected")
        const device = ""
        setDevice(device)
    }

    const sendMessage = async () => {
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
        <>
        <button className="bluetooth" onClick={sendMessage}>CONNECT</button>
        </>
    )

}

export default Bluetooth
