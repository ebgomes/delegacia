package br.com.arquitetura;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Simula {

    /**
     * Cria um proxy que nao chama o mehtodo, apenas finge passar pelo mesmo
     * 
     * @param tipo
     *            deve ser uma interface
     * @return uma instancia "falsa" do tipo passado como parametro
     * @throws DCException
     */
    @SuppressWarnings("unchecked")
    public static <T> T classe(Class<T> tipo) {
        GaranteQue.naoEhNulo(tipo);
        return (T) Proxy.newProxyInstance(tipo.getClassLoader(), new Class[] { tipo }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Executando chamada falsa para o metodo \"" + method.getName() + "\"!");
                return null;
            }
        });
    }

}
