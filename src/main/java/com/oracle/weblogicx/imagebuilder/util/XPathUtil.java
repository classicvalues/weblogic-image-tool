/* Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved. */

package com.oracle.weblogicx.imagebuilder.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringWriter;
import java.io.Writer;

public class XPathUtil {

//    /**
//     * Apply XPath and return the results as nodelist
//     *
//     * @param doc  dom document
//     * @param expression xpath expression
//     * @return nodelist result
//     * @throws XPathExpressionException when xpath failed
//     */
//    public static NodeList applyXPathReturnNodeList(Document doc, String expression) throws XPathExpressionException {
//
//        XPathFactory factory = XPathFactory.newInstance();
//
//        XPath xpath = factory.newXPath();
//
//        NodeList nodeList;
//
//        nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
//        return nodeList;
//
//    }

    /**
     * Apply XPath and return the results as nodelist
     *
     * @param node       node
     * @param expression xpath expression
     * @return nodelist result
     * @throws XPathExpressionException when xpath failed
     */
    public static NodeList applyXPathReturnNodeList(Node node, String expression) throws XPathExpressionException {

        XPathFactory factory = XPathFactory.newInstance();

        XPath xpath = factory.newXPath();

        NodeList nodeList;

        nodeList = (NodeList) xpath.evaluate(expression, node, XPathConstants.NODESET);
        return nodeList;

    }

    /**
     * Apply XPath and return the results as string
     *
     * @param doc        dom document
     * @param expression xpath expression
     * @return string result
     * @throws XPathExpressionException when xpath failed
     */
    public static String applyXPathReturnString(Document doc, String expression) throws XPathExpressionException {

        XPathFactory factory = XPathFactory.newInstance();

        XPath xpath = factory.newXPath();

        return (String) xpath.evaluate(expression, doc, XPathConstants.STRING);

    }

    /**
     * Pretty print the document
     *
     * @param xml dom document
     */
    public static final void prettyPrint(Document xml) {
        try {
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer out = new StringWriter();
            tf.transform(new DOMSource(xml), new StreamResult(out));
            System.out.println(out.toString());
        } catch (TransformerException ex) {
            System.out.println("Failed to print out xml document, probably not a valid document " + ex.getMessage());
        }
    }


}