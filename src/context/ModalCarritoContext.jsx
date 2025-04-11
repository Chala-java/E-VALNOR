import { createContext, useState } from "react";

export const ModalCarritoContext = createContext();

export const ModalCarritoProvider = ({ children }) => {
  const [modalAbierto, setModalAbierto] = useState(false);

  const abrirModal = () => setModalAbierto(true);
  const cerrarModal = () => setModalAbierto(false);
  const toggleModal = () => setModalAbierto((prev) => !prev);

  return (
    <ModalCarritoContext.Provider value={{ modalAbierto, abrirModal, cerrarModal, toggleModal }}>
      {children}
    </ModalCarritoContext.Provider>
  );
};
