import { useEffect } from 'react';
import useGlobalToastr from '../../../context/toastr/toastr.context';
import { TOAST_TYPE } from '../../../hook';
import './toastr.style.css';

const TOASTR_DELAY = 5000;

export function Toastr() {
  const [message, setMessage] = useGlobalToastr({});

  useEffect(() => {
    if (message.message) {
      setTimeout(() => {
        setMessage({});
      }, TOASTR_DELAY);
    }
  }, [message, setMessage]);

  if (!message.message) {
    return;
  }

  return (
    <div
      className={`toastr fade ${
        message.type === TOAST_TYPE.SUCCESS ? 'success' : ''
      }`}
    >
      <p className="toastr-message">{message.message}</p>
    </div>
  );
}
