import { RouterProvider } from 'react-router-dom';
import { GlobalToastrProvider } from './context/toastr/toastr.context';
import { GlobalUserProvider } from './context/user/user.context';
import { router } from './router';
import { Toastr } from './ui/components/toastr/toastr.component';

function App() {
  return (
    <GlobalUserProvider>
      <GlobalToastrProvider>
        <RouterProvider router={router} />
        <Toastr message="Error trying to login" />
      </GlobalToastrProvider>
    </GlobalUserProvider>
  );
}

export default App;
