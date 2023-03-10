import { useNavigate } from 'react-router-dom';
import { logout } from '../../api/auth/logout.api';
import useGlobalUser from '../../context/user/user.context';

export function useLogout() {
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function handleLogout() {
    logout();
    setUser(null);
    localStorage.removeItem('user');
    localStorage.removeItem('character');
    navigate('/');
  }

  return { handleLogout };
}
