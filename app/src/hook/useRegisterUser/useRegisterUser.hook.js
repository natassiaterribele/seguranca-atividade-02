import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { register } from '../../api/auth/register.api';
import useGlobalToastr from '../../context/toastr/toastr.context';
import { TOAST_TYPE, useToastr } from '../index';

export function useRegisterUser() {
  const [registerInputs, setRegisterInputs] = useState({
    username: '',
    password: '',
    mail: '',
    phone: '',
    imageUrl: '',
  });
  const navigate = useNavigate();
  const showToastr = useToastr();
  const [message, setMessage] = useGlobalToastr();

  async function handleSubmit(event) {
    event.preventDefault();

    try {
      if (registerInputs.username === '') {
        showToastr('Preencha seu nome!');
      } else if (registerInputs.password === '') {
        showToastr('Defina uma senha!');
      } else if (registerInputs.mail === '') {
        showToastr('Preencha o campo email!');
      } else if (registerInputs.phone === '') {
        showToastr('Preencha o campo telefone!');
      } else if (registerInputs.imageUrl === '') {
        showToastr('Preencha a url da sua foto!');
      } else {
        await register(registerInputs);
        showToastr(
          'Cadastro realizado! Faça login para continuar.',
          TOAST_TYPE.SUCCESS
        );
        navigate('/');
      }
    } catch (error) {
      showToastr(error?.response?.data?.message || error?.response?.statusText);
    }
  }

  function handleChange(event) {
    const { name, value } = event.target;

    setRegisterInputs((oldRegisterInputs) => ({
      ...oldRegisterInputs,
      [name]: value,
    }));
  }

  return {
    registerInputs,
    handleChange,
    handleSubmit,
  };
}
