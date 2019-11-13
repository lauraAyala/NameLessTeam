import React from 'react';
import {withRouter} from 'react-router';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";
import Col from "react-bootstrap/Col";
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


    handleChange(value, prop) {
        this.setState(prevState => ({...prevState, [prop]: value}));
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
                <div>
                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand href="/home">Ferretería</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link href="/RegistrarCliente">Registrar Cliente</Nav.Link>
                            <Nav.Link href="/RegistrarProducto">Registrar Producto</Nav.Link>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2"/>
                            <Button variant="outline-info">Search</Button>
                        </Form>
                    </Navbar>
                </div>
                <div className={"RegistarCliente"}>
                    <Form>
                        <h1>Registrar Cliente</h1>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formNombre">
                                <Form.Label>Nombre</Form.Label>
                                <Form.Control type="text" placeholder="Nombre"
                                              value={this.state.nombre}
                                              onChange={event => this.handleChange(event.target.value, 'nombre')}/>
                            </Form.Group>

                            <Form.Group as={Col} controlId="formApellido">
                                <Form.Label>Apellido</Form.Label>
                                <Form.Control type="text" placeholder="Apellido"
                                              value={this.state.apellido}
                                              onChange={event => this.handleChange(event.target.value, 'apellido')}/>
                            </Form.Group>
                        </Form.Row>

                        <Form.Group controlId="formDomicilio">
                            <Form.Label>Domicilio</Form.Label>
                            <Form.Control placeholder="Domicilio"
                                          value={this.state.domicilio}
                                          onChange={event => this.handleChange(event.target.value, 'domicilio')}/>
                        </Form.Group>

                        <Form.Group controlId="formContacto">
                            <Form.Label>Teléfono de Contacto</Form.Label>
                            <Form.Control placeholder="Teléfono de Contacto"
                                          value={this.state.contacto}
                                          onChange={event => this.handleChange(event.target.value, 'contacto')}/>
                        </Form.Group>

                        <Form.Row>
                            <Form.Group as={Col} controlId="formCUIT">
                                <Form.Label>CUIT</Form.Label>
                                <Form.Control value={this.state.cuit}
                                              onChange={event => this.handleChange(event.target.value, 'cuit')}/>
                            </Form.Group>
                            <Form.Group id="formCheckbox">
                                <Form.Check type="checkbox" label="Consumidor Final"
                                            value={this.state.esConsumidorFinal}
                                            onChange={event => this.handleChange(event.target.value, 'esConsumidorFinal')}/>
                            </Form.Group>
                            <Form.Group id="formCheckbox">
                                <Form.Check type="checkbox" label="Responsable Inscripto"
                                            value={this.state.esResponsableInscripto}
                                            onChange={event => this.handleChange(event.target.value, 'esResponsableInscripto')}/>
                            </Form.Group>
                        </Form.Row>
                        <Button className={"RegisterButton"} onClick={() => this.handleClick()}>
                            Registrar
                        </Button>
                        <Button className="cancelButton" onClick={() => this.handleClick2()}>Cancelar</Button>
                    </Form>
                </div>
            </div>
        );
    }


}

export default withRouter(RegistrarCliente);