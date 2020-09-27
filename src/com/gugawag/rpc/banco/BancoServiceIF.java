package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void adicionarConta(String numero, Double saldo) throws RemoteException;
    Conta pesquisarConta(String numeroConta) throws RemoteException;
    String removerConta(String numeroConta) throws RemoteException;
}
