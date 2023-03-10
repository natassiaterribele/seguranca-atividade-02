import { Navigate } from 'react-router-dom';
import useGlobalUser from '../context/user/user.context';

const URL_LOGIN_PAGE = '/';

export function PrivateRoute({ Screen }) {
  const [user] = useGlobalUser();

  if (user) {
    return <Screen />;
  }

  return <Navigate to={URL_LOGIN_PAGE} />;
}
