package br.com.arquitetura;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrlUtils {

    /**
     * Monta uma string com as chaves do mapa no estilo ?chave={chave}&chave2={chave2}
     *
     * @param parametros mapa de parametros
     * @return mapa convertido em uma string de parametros para uma URL
     */
    public static String montaStringComParametrosParaURL(Map<String, ?> parametros) {
        boolean ehOPrimeiroParametro = true;
        StringBuilder url = new StringBuilder();
        for (Entry<String, ?> parametro : parametros.entrySet()) {
            if (ConfirmaQue.ehNulo(parametro.getValue())) {
                continue;
            }
            if (ConfirmaQue.nao(ehOPrimeiroParametro)) {
                url.append("&");
            }
            url.append(parametro.getKey()).append("={").append(parametro.getKey()).append("}");
            ehOPrimeiroParametro = false;
        }
        return "?" + url.toString();
    }

    public static Map<String, List<String>> converteStringComQueryParaMapaDeParametros(String url) {
        try {
            Map<String, List<String>> params = new HashMap<String, List<String>>();
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                for (String param : query.split("&")) {
                    String[] pair = param.split("=");
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }

                    List<String> values = params.get(key);
                    if (values == null) {
                        values = new ArrayList<String>();
                        params.put(key, values);
                    }
                    values.add(value);
                }
            }

            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }

    public static Map<String, List<String>> converteStringComQueryParaMapaDeParametros(URL url) {
        return converteStringComQueryParaMapaDeParametros(url.toString());
    }

    public static String geraBaseDaUrl(URL url) {
        return url.getProtocol() + ":" + "//" + url.getHost() + (url.getPort() == -1 ? "" : ":" + url.getPort());
    }

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(UrlUtils.geraBaseDaUrl(new URL("http://www.teste.com.br:80/xyz")));
    }

}
