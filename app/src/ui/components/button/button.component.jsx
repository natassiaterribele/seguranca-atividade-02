import './button.style.css';
export function Button({ children, onClick, className }) {
  return (
    <button className={`button-style ${className}`} onClick={onClick}>
      {children}
    </button>
  );
}
