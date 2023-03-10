import './formContainer.style.css';
export function FormContainer({ children }) {
  return (
    <div className="center-form">
      <div className="container-form">{children}</div>
    </div>
  );
}
