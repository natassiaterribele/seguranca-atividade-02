import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../../api/auth/login.api';
import { getUserData } from '../../api/user/getUserData.api';
import useGlobalUser from '../../context/user/user.context';
import { useToastr } from '../index';

export function useFormInputs() {
  const [formInputs, setFormInputs] = useState({ username: '', password: '' });
  const [user, setUser] = useGlobalUser();
  const navigate = useNavigate();
  const showToastr = useToastr();
  const loginInputs = {
    username: formInputs.username,
    password: formInputs.password,
  };
  async function handleSubmit(event) {
    event.preventDefault();

    try {
      const loginResponse = await login(loginInputs);
      if (loginResponse.nome !== '') {
        const userData = await getUserData();
        setUser(userData);
      } else {
        showToastr(
          'Verifique o seu usuário e senha, estes campos não podem estar vazios'
        );
      }
    } catch (error) {
      showToastr(
        'Erro ao logar, por favor verifique o seu usuário e senha e tente novamente!'
      );
    }
  }

  useEffect(() => {
    if (user) {
      navigate('/home');
    }
  }, [user]);

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
