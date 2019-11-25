import React from 'react';
import './App.css';

const Producto = ({data}) => {
    const {idCodigo, descripcion, precioCompra, precioVenta, stock} = data;

    return (
        <tr>
            <td>{idCodigo}</td>
            <td>{descripcion}</td>
            <td>{precioCompra}</td>
            <td>{precioVenta}</td>
            <td>{stock}</td>
        </tr>
    );
};

export default Producto;