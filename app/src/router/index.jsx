import { createBrowserRouter } from 'react-router-dom';
import {
  HomeScreen,
  RegisterUserScreen,
  UserLoginScreen,
} from '../ui/screens/index';
import { PrivateRoute } from './private-route.component';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <UserLoginScreen />,
  },
  {
    path: '/home',
    element: <PrivateRoute Screen={HomeScreen} />,
  },
  {
    path: 'register',
    element: <RegisterUserScreen />,
  },
]);
