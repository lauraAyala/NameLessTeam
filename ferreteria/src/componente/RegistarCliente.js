import React from 'react';
import {withRouter} from 'react-router';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from "axios"
import Alert from "react-bootstrap/Alert";

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
            esResponsableInscripto: '',
            error: ''
        };

    }


    handleClick() {
        const {nombre, apellido, domicilio, contacto, cuit, esConsumidorFinal, esResponsableInscripto} = this.state;
        let params = {nombre, apellido, domicilio, contacto, cuit, esConsumidorFinal, esResponsableInscripto};


        if (this.validarDatos(params)) {
            let endpoint = 'http://localhost:7000/registrar';
            axios.post(endpoint, params)
                .then(response => this.props.history.push('/', response.body))
                .catch((error) => this.setState({error: error.response.data.title}))
        }
    }


    handleClick2() {
        this.props.history.push('/');
    }


    isEmpty(value) {
        return (typeof value === 'undefined' || value === null || value === '');
    }


    validarDatos(params) {
        if (this.isEmpty(params.nombre) && this.isEmpty(params.apellido) && this.isEmpty(params.domicilio) && this.isEmpty(params.cuit) && this.isEmpty(params.contacto)) {
            this.setState({error: 'Por favor, complete todos los datos.'});
            return false
        }

        if (isNaN(params.contacto)) {
            this.setState({error: 'Por favor, ingrese un número de télefono válido.'});
            return false
        }

        return true;
    }


    render(placeholder,label) {
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
                                            <input placeholder={placeholder || label} value={this.state.nombre, "Nombre"}
                                                   onChange={event => this.setState({nombre: event.target.value})}
                                                   type="text"
                                                   className="form-control"
                                            />


                                            <label>Apellido:</label>
                                            <input placeholder={placeholder || label} value={this.state.apellido,"Apellido"}
                                                   onChange={event => this.setState({apellido: event.target.value})}
                                                   type={"text"}
                                                   className="form-control"
                                            />


                                            <label>Domicilio:</label>
                                            <input placeholder={placeholder || label} value={this.state.domicilio,"Domicilio"}
                                                   onChange={event => this.setState({domicilio: event.target.value})}
                                                   type={"text"}
                                                   className="form-control"
                                            />

                                            <label>Telefono de Contacto:</label>
                                            <input placeholder={placeholder || label} value={this.state.contacto, "Telefono"}
                                                   onChange={event => this.setState({contacto: event.target.value})}
                                                   type={"numeric"}
                                                   className="form-control"
                                            />

                                            <label>CUIT:</label>
                                            <input placeholder={placeholder || label} value={this.state.cuit, "Cuit"}
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
                                <div className={"Warning mt-4 col-12"}>
                                    {this.state.error &&
                                    <Alert variant="danger">{this.state.error}</Alert>}
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