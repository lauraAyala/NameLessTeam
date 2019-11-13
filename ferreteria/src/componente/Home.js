import './App.css';
import React from 'react';
import {withRouter} from 'react-router';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import FormControl from "react-bootstrap/FormControl";


class Home extends React.Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            <div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href="/home">Hardware Storage</Navbar.Brand>
                    <Nav className="mr-auto">
                        <Nav.Link href="/RegistrarCliente">Registrar Cliente</Nav.Link>
                        <Nav.Link href="/registrarProducto">Registrar Producto</Nav.Link>
                        <Nav.Link href="#pricing">New Feature</Nav.Link>
                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2"/>
                        <Button variant="outline-info">Search</Button>
                    </Form>
                </Navbar>

            </div>

        );
    }


}

export default withRouter(Home);