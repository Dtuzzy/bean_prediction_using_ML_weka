package com.beans.implement;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.supervised.attribute.AddClassification;


public class dataSetClasss {
	JLabel lab;
	JTextArea modelInfo;
	
public void  dataClasss (JLabel info,JTextArea modelInfo) throws Exception {
	this.lab = info;
	this.modelInfo = modelInfo;
		DataSource source = new DataSource("C://Users//Public//beans.arff");
		Instances traindata = source.getDataSet();
		traindata.setClassIndex(traindata.numAttributes()-1);
		int numClasses = traindata.numClasses();
		for (int i=0;i<numClasses;i++){
			String classValue = traindata.classAttribute().value(i);
			System.out.println("the "+i+"th class value:"+classValue);
		}
		/**
		 * naive bayes classifier	
		 */
		J48 nb = new J48();
		nb.buildClassifier(traindata);
		
		modelInfo.append("Model Information \n\n"+nb);
		/**
		 * load test data
		 */
		DataSource source2 = new DataSource("C://Users//Public//beans_pro.arff");
		
		Instances testdata = source2.getDataSet();
		testdata.setClassIndex(testdata.numAttributes()-1);
		
		
		/**
		 * make prediction by naive bayes classifier
		 */
		for (int j=0;j<testdata.numInstances();j++){
			double actualClass = testdata.instance(j).classValue();
			String actual = testdata.classAttribute().value((int) actualClass);
			Instance newInst = testdata.instance(j);
			System.out.println("actual class:"+newInst.stringValue(newInst.numAttributes()-1));
			double preNB = nb.classifyInstance(newInst);
			String predString = testdata.classAttribute().value((int) preNB);
			lab.setText(predString);
			System.out.println(actual+","+predString);
		}
		
		
		
	}

}