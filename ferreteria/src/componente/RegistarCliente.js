import React from 'react';
import {withRouter} from 'react-router';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from "axios"

axios.defaults.headers.post['Content-Type'] = 'application/json';


class RegistrarCliente extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            nombre: '',
            apellido: '',
            domicilio: '',
            contacto: '',
            cuit: '',
            esConsumidorFinal: '',
            esResponsableInscripto: ''
        };

    }


    handleClick() {
        const {nombre, apellido, domicilio, contacto, cuit, esConsumidorFinal, esResponsableInscripto} = this.state;
        let params = {nombre, apellido, domicilio, contacto, cuit, esConsumidorFinal, esResponsableInscripto};

        console.log({
            nombre: nombre,
            apellido: apellido,
            domicilio: domicilio,
            contacto: contacto,
            cuit: cuit,
            esConsumidorFinal: esConsumidorFinal,
            esResponsableInscripto: esResponsableInscripto
        });

        let endpoint = 'http://localhost:7000/registrar';

        axios.post(endpoint, params)
            .then(response => this.props.history.push('/', response.body))
            .catch((error) => console.log(error));
    }


    handleClick2() {
        this.props.history.push('/');
    }

    render() {
        return (
            <div>
                <div className={"MiddlePage"}>
                    <form>
                        <div className="container flex-center">
                            <div className={"RegistarCliente"}>
                                <h3 className="p30">Por favor, complete todos los campos.</h3>
                                <div className="FormContainer">
                                    <div className="row">
                                        <div className="col-sm-12 mb-30">
                                            <label>Nombre:</label>
                                            <input value={this.state.nombre}
                                                   onChange={event => this.setState({nombre: event.target.value})}
                                                   type="text"
                                                   className="form-control"
                                            />


                                            <label>Apellido:</label>
                                            <input value={this.state.apellido}
                                                   onChange={event => this.setState({apellido: event.target.value})}
                                                   type={"text"}
                                                   className="form-control"
                                            />


                                            <label>Domicilio:</label>
                                            <input value={this.state.domicilio}
                                                   onChange={event => this.setState({domicilio: event.target.value})}
                                                   type={"text"}
                                                   className="form-control"
                                            />

                                            <label>Telefono de Contacto:</label>
                                            <input value={this.state.contacto}
                                                   onChange={event => this.setState({contacto: event.target.value})}
                                                   type={"numeric"}
                                                   className="form-control"
                                            />

                                            <label>CUIT:</label>
                                            <input value={this.state.cuit}
                                                   onChange={event => this.setState({cuit: event.target.value})}
                                                   type={"numeric"}
                                                   className="form-control"
                                            />

                                            <Form.Group id="formCheckbox">
                                                <Form.Check type="checkbox" label="Consumidor Final"
                                                            onChange={event => this.setState({esConsumidorFinal: event.target.checked})}

                                                />
                                                <Form.Check type="checkbox" label="Responsable Inscripto"
                                                            onChange={event => this.setState({esResponsableInscripto: event.target.checked})}
                                                />
                                            </Form.Group>
                                        </div>
                                    </div>
                                </div>
                                <div className="mt-4 flex-center">
                                    <Button onClick={() => this.handleClick()}>Registrar</Button>
                                    <Button variant="dark" className={"ml-1rem"}
                                            onClick={() => this.handleClick2()}>Cancelar</Button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        );
    }


}

export default withRouter(RegistrarCliente);