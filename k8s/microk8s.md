1. How to grant a normal user the permission to microk8s

   ruibin@E590:~$ microk8s enable dashboard
    Insufficient permissions to access MicroK8s.
    You can either try again with sudo or add the user ruibin to the 'microk8s' group:

    sudo usermod -a -G microk8s ruibin
    sudo chown -R ruibin ~/.kube
