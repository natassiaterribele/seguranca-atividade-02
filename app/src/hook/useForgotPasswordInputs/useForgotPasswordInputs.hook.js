import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { forgotPassword } from '../../api/user/forgotPassword.api';
import { useToastr } from '../index';

export function useForgotPasswordInputs() {
  const [formInputs, setFormInputs] = useState({ email: '' });
  const navigate = useNavigate();
  const showToastr = useToastr();
  const forgotPasswordInputs = {
    email: formInputs.email,
  };
  async function handleSubmit(event) {
    event.preventDefault();

    try {
      await forgotPassword(forgotPasswordInputs);
      showToastr(
        'As instruções para alteração da senha foram enviadas por email'
      );
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
