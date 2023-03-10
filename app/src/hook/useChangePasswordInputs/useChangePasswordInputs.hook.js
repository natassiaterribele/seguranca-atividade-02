import { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { changePassword } from '../../api/user/changePassword.api';
import { useToastr } from '../index';

export function useChangePasswordInputs() {
  const [formInputs, setFormInputs] = useState({ password: '' });
  const navigate = useNavigate();
  const showToastr = useToastr();
  const { token } = useParams();
  const changePasswordInputs = {
    password: formInputs.password,
  };
  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await changePassword(changePasswordInputs.password, token);
      showToastr('Senha alterada com sucesso');
      navigate('/');
    } catch (error) {
      showToastr(error.response?.data?.message || error.message);
    }
  }

  function handleChange(event) {
    const { name, value } = event.target;

    setFormInputs((oldFormInputs) => ({
      ...oldFormInputs,
      [name]: value,
    }));
  }

  return {
    formInputs,
    handleChange,
    handleSubmit,
  };
}
