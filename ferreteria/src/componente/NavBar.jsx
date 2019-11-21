import React from 'react';
import './App.css';
import {Link, withRouter} from "react-router-dom";
import {Nav, Navbar} from "react-bootstrap";


class NavBarDW extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Navbar bg="dark" variant="dark">
                    <Link className="nav-link"
                          to={{pathname: "/home"}}>Ferretería</Link>
                    <Nav className="mr-auto">
                        <Link className="nav-link" to={{
                            pathname: "/RegistrarCliente"
                        }}>Registrar Cliente</Link>
                        <Link className="nav-link"
                              to={{pathname: "/RegistrarProducto"}}>Registrar Producto</Link>
                        <Link className="nav-link"
                              to={{pathname: "/clientes"}}>Clientes Activos</Link>
                        <Link className="nav-link"
                              to={{pathname: "/productos"}}>Productos</Link>
                        <Link className="nav-link"
                              to={{pathname: "/registrarVenta"}}>Registrar Venta</Link>
                    </Nav>
                </Navbar>
            </div>
        );
    }

}

export default withRouter(NavBarDW);