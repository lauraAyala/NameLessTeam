import React, {Component} from 'react';
import {registrarVenta} from './api/Api';
import Form from "react-bootstrap/Form";


export default class RealizarVenta extends Component {
    constructor(props) {
        super(props);

        this.state = {
            codigoProducto: '',
            clienteId: '',
            precioVenta: '',
            unidades: '',
            error: ''
        };

        this.changeCodigoVenta = this.changeCodigoVenta.bind(this);
        this.changeClienteId = this.changeClienteId.bind(this);
        this.changePrecioVenta = this.changePrecioVenta.bind(this);
        this.changeUnidades = this.changeUnidades.bind(this);
        this.executeRegister = this.executeRegister.bind(this);
    }


    changeCodigoVenta(event) {
        this.setState({codigoProducto: event.target.value});
    }

    changeClienteId(event) {
        this.setState({clienteId: event.target.value});
    }

    changePrecioVenta(event) {
        this.setState({precioVenta: event.target.value});
    }

    changeUnidades(event) {
        this.setState({unidades: event.target.value});
    }

    executeRegister() {
        registrarVenta({
            idCodigo: this.state.codigoProducto,
            clienteId: this.state.clienteId,
            precioVenta: this.state.precioVenta,
            unidades: this.state.unidades
        })
            .then((res) => {
                console.log(res)
                this.props.history.push('/');


            }).catch((error) => {
            this.setState({error: error.response.data.message})

        })

    }

    handleClickBack() {
        this.props.history.push(`/`);
    }

    renderInput(label, value, inputType, onChange) {
        return (
            <div className="form-group row">
                <label className="col-sm-3 col-form-label">{label}</label>
                <div className="col-sm-9">
                    <input type={inputType} className="form-control" value={value} onChange={onChange}/>
                </div>
            </div>
        );
    }

    render() {
        return (
            <div className="RegistrarVenta">
                <div className="container flex-center">
                    <Form>
                        <h1> Registrar Venta </h1>
                        <div className="FormContainer ">
                            <Form.Row
                                className="p30">{this.renderInput('Codigo Producto', this.state.codigoProducto, 'numeric', this.changeCodigoVenta)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('CUIT Cliente', this.state.clienteId, 'text', this.changeClienteId)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('Precio De Venta', this.state.precioVenta, 'numeric', this.changePrecioVenta)}</Form.Row>
                            <Form.Row
                                className="p30">{this.renderInput('Unidades', this.state.unidades, 'numeric', this.changeUnidades)}</Form.Row>
                        </div>
                        <div className="col-12 p30 flex-center ">
                            <button type="button" className="btn btn-primary" onClick={this.executeRegister}>Registrar
                            </button>
                            <button type="button" className=" btn btn-secondary ml-1rem "
                                    onClick={() => this.handleClickBack()}>Volver
                            </button>
                        </div>
                    </Form>
                </div>
            </div>
        );
    }
}

