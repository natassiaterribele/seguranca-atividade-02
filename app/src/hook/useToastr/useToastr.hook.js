import useGlobalToastr from '../../context/toastr/toastr.context';

export const TOAST_TYPE = {
  ERROR: 'Erro',
  SUCCESS: 'Sucesso',
};

export function useToastr() {
  const [, setToastr] = useGlobalToastr();

  function showToastr(message, type = TOAST_TYPE.ERROR) {
    setToastr({ message: message, type: type });
  }

  return showToastr;
}
