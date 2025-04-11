import { useState, useEffect } from "react";
import axios from "axios";
import "./Admin.css";

function Admin() {
  const [producto, setProducto] = useState({
    producto_nombre: "",
    producto_marca: "",
    producto_descripcion: "",
    producto_precio: "",
    producto_categoria: "",
    producto_cantidad: "",
    producto_imagen: "",
  });

  const [productos, setProductos] = useState([]);
  const [editandoId, setEditandoId] = useState(null);

  useEffect(() => {
    cargarProductos();
  }, []);

  const cargarProductos = async () => {
    const res = await axios.get("http://localhost:8080/productos");
    setProductos(res.data);
  };

  const handleInput = (e) => {
    setProducto({ ...producto, [e.target.name]: e.target.value });
  };

  const crearProducto = async (e) => {
    e.preventDefault();

    if (editandoId) {
      await axios.put(`http://localhost:8080/productos/${editandoId}`, producto);
      setEditandoId(null);
    } else {
      await axios.post("http://localhost:8080/productos", producto);
    }

    setProducto({
      producto_nombre: "",
      producto_marca: "",
      producto_descripcion: "",
      producto_precio: "",
      producto_categoria: "",
      producto_cantidad: "",
      producto_imagen: "",
    });

    cargarProductos();
  };

  const eliminarProducto = async (id) => {
    await axios.delete(`http://localhost:8080/productos/${id}`);
    cargarProductos();
  };

  const editarProducto = (p) => {
    setProducto({
      producto_nombre: p.producto_nombre,
      producto_marca: p.producto_marca,
      producto_descripcion: p.producto_descripcion,
      producto_precio: p.producto_precio,
      producto_categoria: p.producto_categoria,
      producto_cantidad: p.producto_cantidad,
      producto_imagen: p.producto_imagen,
    });
    setEditandoId(p.id_Producto);
  };

  return (
    <div className="contenedor">
      <h2>{editandoId ? "Editar Producto" : "Crear Producto"}</h2>
      <form onSubmit={crearProducto}>
        <input name="producto_nombre" placeholder="Nombre" onChange={handleInput} value={producto.producto_nombre} />
        <input name="producto_marca" placeholder="Marca" onChange={handleInput} value={producto.producto_marca} />
        <input name="producto_descripcion" placeholder="Descripción" onChange={handleInput} value={producto.producto_descripcion} />
        <input name="producto_precio" type="number" placeholder="Precio" onChange={handleInput} value={producto.producto_precio} />
        <input name="producto_categoria" placeholder="Categoría" onChange={handleInput} value={producto.producto_categoria} />
        <input name="producto_cantidad" type="number" placeholder="Cantidad" onChange={handleInput} value={producto.producto_cantidad} />
        <input name="producto_imagen" placeholder="URL de imagen" onChange={handleInput} value={producto.producto_imagen} />
        <button type="submit">{editandoId ? "Actualizar" : "Crear"}</button>
      </form>

      <h3>Productos</h3>
      {productos.map((p) => (
        <div key={p.id_Producto} className="producto">
          <p>Nombre: {p.producto_nombre}</p>
          <p>Marca: {p.producto_marca}</p>
          <p>Descripción: {p.producto_descripcion}</p>
          <p>Precio: {p.producto_precio}</p>
          <p>Categoría: {p.producto_categoria}</p>
          <p>Cantidad: {p.producto_cantidad}</p>
          {p.producto_imagen && (
            <img src={p.producto_imagen} alt={p.producto_nombre} className="img-producto" />
          )}
         <div style={{ display: "flex", gap: "10px", marginTop: "10px" }}>
            <button onClick={() => editarProducto(p)}>Editar</button>
            <button onClick={() => eliminarProducto(p.id_Producto)}>Eliminar</button>
          </div>
        </div>
      ))}
    </div>
  );
}

export default Admin;
