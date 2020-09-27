package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

//    private Map<String, Double> saldoContas;
    private List<Conta> contas;
    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
        contas.add(new Conta("1", 100));
        contas.add(new Conta("2", 150));
    }

    @Override
    public void adicionarConta(String numero, Double saldo)  {
        Conta conta = new Conta(numero, saldo);
        contas.add(conta);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        double saldo = 0;
        for(Conta c : contas) {
            if(c.getNumero().equals(conta))
                return c.getSaldo();
        }
        return saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public Conta pesquisarConta(String numero) throws RemoteException{
        Conta conta = null;
        for(Conta c: contas){
            if(c.getNumero().equals((numero)))
                conta = c;
        }
        return conta;
    }

    @Override
    public String removerConta(String numeroConta) throws RemoteException{
        Conta conta = pesquisarConta(numeroConta);
        contas.remove(conta);
        return "A conta:" +conta+ "foi removida!!!";
    }
}
