import { useNavigate } from 'react-router-dom';
import { logout } from '../../../api/auth/logout.api';
import useGlobalUser from '../../../context/user/user.context';
import { useToastr } from '../../../hook';
import { Button } from '../../components';

export function HomeScreen() {
  const [_user, setUser] = useGlobalUser();
  const navigate = useNavigate();
  const showToastr = useToastr();

  async function onLogoutClick() {
    try {
      await logout();
      setUser(null);
      navigate('/');
    } catch (error) {
      showToastr(error.response?.data?.message || error.message);
    }
  }

  return (
    _user && (
      <>
        <p>{_user.nome}</p>
        <p>{_user.email}</p>
        <img src={_user.fotoUrl} alt="Imagem do usuário" />
        <Button onClick={onLogoutClick}>Sair</Button>
      </>
    )
  );
}
