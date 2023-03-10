import './linkButton.style.css';

export function LinkButton({ link, linkButtonName }) {
  return (
    <a className="link-button-style" href={link}>
      {linkButtonName}
    </a>
  );
}
