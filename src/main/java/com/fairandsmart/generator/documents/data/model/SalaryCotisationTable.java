package com.fairandsmart.generator.documents.data.model;

/*-
 * #%L
 * FacoGen / A tool for annotated GEDI based invoice generation.
 * 
 * Authors:
 * 
 * Xavier Lefevre <xavier.lefevre@fairandsmart.com> / FairAndSmart
 * Nicolas Rueff <nicolas.rueff@fairandsmart.com> / FairAndSmart
 * Alan Balbo <alan.balbo@fairandsmart.com> / FairAndSmart
 * Frederic Pierre <frederic.pierre@fairansmart.com> / FairAndSmart
 * Victor Guillaume <victor.guillaume@fairandsmart.com> / FairAndSmart
 * Jérôme Blanchard <jerome.blanchard@fairandsmart.com> / FairAndSmart
 * Aurore Hubert <aurore.hubert@fairandsmart.com> / FairAndSmart
 * Kevin Meszczynski <kevin.meszczynski@fairandsmart.com> / FairAndSmart
 * %%
 * Copyright (C) 2019 Fair And Smart
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.fairandsmart.generator.documents.data.generator.GenerationContext;
import com.fairandsmart.generator.documents.data.generator.ModelGenerator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class SalaryCotisationTable {

    private List<SalaryLine> salaryTableLines = new ArrayList<SalaryLine>();

    // News
    private String codeElementHead;
    private String headingHead;
    private String baseHead;
    private String salaryRateHead;
    private String employeeContrHead;
    private String employerRateHead;
    private String employerContrHead;


    public SalaryCotisationTable(String codeElementHead, String headingHead, String baseHead, String salaryRateHead, String employeeContrHead,
                                 String employerRateHead, String employerContrHead) {
        this.codeElementHead = codeElementHead;
        this.headingHead = headingHead;
        this.baseHead = baseHead;
        this.salaryRateHead = salaryRateHead;
        this.employeeContrHead = employeeContrHead;
        this.employerRateHead = employerRateHead;
        this.employerContrHead = employerContrHead;
    }

    public void addLineSalary(SalaryLine sLine) {
        salaryTableLines.add(sLine);
        // TODO ADD THE NECESSARY CALCULATIONS
            }

    public List<SalaryLine> getSalaryTableLines() {
        return salaryTableLines;
    }

    public String getCodeElementHead() {
        return codeElementHead;
    }

    public String getHeadingHead() {
        return headingHead;
    }

    public String getBaseHead() {
        return baseHead;
    }

    public String getSalaryRateHead() {
        return salaryRateHead;
    }

    public String getEmployeeContrHead() {
        return employeeContrHead;
    }

    public String getEmployerRateHead() {
        return employerRateHead;
    }

    public String getEmployerContrHead() {
        return employerContrHead;
    }

    public void setSalaryTableLines(List<SalaryLine> salaryTableLines) {
        this.salaryTableLines = salaryTableLines;
    }

    public void setCodeElementHead(String codeElementHead) {
        this.codeElementHead = codeElementHead;
    }

    public void setHeadingHead(String headingHead) {
        this.headingHead = headingHead;
    }

    public void setBaseHead(String baseHead) {
        this.baseHead = baseHead;
    }

    public void setSalaryRateHead(String salaryRateHead) {
        this.salaryRateHead = salaryRateHead;
    }

    public void setEmployeeContrHead(String employeeContrHead) {
        this.employeeContrHead = employeeContrHead;
    }

    public void setEmployerRateHead(String employerRateHead) {
        this.employerRateHead = employerRateHead;
    }

    public void setEmployerContrHead(String employerContrHead) {
        this.employerContrHead = employerContrHead;
    }

    @Override
    public String toString() {
        return "SalaryCotisationTable{" +
                "salaryTableLines=" + salaryTableLines +
                '}';
    }

    public static class Generator implements ModelGenerator<SalaryCotisationTable> {

        private static final Map<String, String> codeElementHeads = new LinkedHashMap<>();
        private static final Map<String, String> headingHeads = new LinkedHashMap<>();
        private static final Map<String, String> baseHeads = new LinkedHashMap<>();
        private static final Map<String, String> salaryRateHeads = new LinkedHashMap<>();
        private static final Map<String, String> employeeContrHeads = new LinkedHashMap<>();
        private static final Map<String, String> employerRateHeads = new LinkedHashMap<>();
        private static final Map<String, String> employerContrHeads = new LinkedHashMap<>();

        {
            codeElementHeads.put("Élément", "fr");

        }

        {
            headingHeads.put("Désignation", "fr");
            headingHeads.put("Rubriques", "fr");
            headingHeads.put("libellé", "fr");

        }

        {
            baseHeads.put("Base", "fr");
            baseHeads.put("Nombre ou base", "fr");
            baseHeads.put("Quantité ou base", "fr");

        }

        {
            salaryRateHeads.put("Taux salarial", "fr");
            salaryRateHeads.put("Taux ou %", "fr");
            salaryRateHeads.put("Tx. SAL", "fr");
            salaryRateHeads.put("TAUX", "fr");

        }

        {
            employeeContrHeads.put("Cot. Salariales", "fr");
            employeeContrHeads.put("Montant", "fr");
            employeeContrHeads.put("Mt. SAL", "fr");
            employeeContrHeads.put("Montant salarial", "fr");
            employeeContrHeads.put("À déduire", "fr");

        }

        {
            employerRateHeads.put("Taux patronal", "fr");
            employerRateHeads.put("Tx. PAT", "fr");
            employerRateHeads.put("Taux", "fr");

        }

        {
            employerContrHeads.put("Cot. Patronales", "fr");
            employerContrHeads.put("Montant", "fr");
            employerContrHeads.put("Mt. PAT", "fr");
            employerContrHeads.put("Mt. Patronal", "fr");

        }

        // cotisations santé
        private List<List<SalaryLine>> santeCotisations;// products;
        private static final String cotisationFileSante = "payslips/cotisations_santé.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(cotisationFileSante));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            santeCotisations = gson.fromJson(jsonReader, collectionType);
        }
        // cotisations accidents de travail
        private List<List<SalaryLine>> accidentCotisation;// products;
        private static final String cotisationFileAccident = "payslips/cotisations_accidents.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(cotisationFileAccident));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            accidentCotisation = gson.fromJson(jsonReader, collectionType);
        }
        // cotisation retraite
        private List<List<SalaryLine>> retaraiteCotisation;// products;
        private static final String cotisationFileRetraite = "payslips/cotisations_retraite.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(cotisationFileRetraite));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            retaraiteCotisation = gson.fromJson(jsonReader, collectionType);
        }
        // cotisations prestations familiales
        private List<List<SalaryLine>> prestationsCotisation;// products;
        private static final String cotisationFilePrest = "payslips/cotisations_prestation_fam.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(cotisationFilePrest));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            prestationsCotisation = gson.fromJson(jsonReader, collectionType);
        }
        // cotisations chomage
        private List<List<SalaryLine>> chomageCotisation;// products;
        private static final String cotisationFileChomage = "payslips/cotisations_chomage.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(cotisationFileChomage));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            chomageCotisation = gson.fromJson(jsonReader, collectionType);
        }
        // composantes remuneration
        private List<List<SalaryLine>> composantesRenum;// products;
        private static final String composantesRenumFile = "payslips/composantes_remunération.json";
        {
            Reader jsonReader = new InputStreamReader(SalaryCotisationTable.class.getClassLoader().getResourceAsStream(composantesRenumFile));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Collection<SalaryLine>>>(){}.getType();
            composantesRenum = gson.fromJson(jsonReader, collectionType);
        }


        @Override
        public SalaryCotisationTable generate(GenerationContext ctx) {

            List<String> localcodeElementHead = codeElementHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localheadingHead = headingHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localbaseHead = baseHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localsalaryRateHead = salaryRateHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localemployeeContrHead = employeeContrHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localemployerRateHead = employerRateHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());
            List<String> localemployerContrHead = employerContrHeads.entrySet().stream().filter(entry -> entry.getValue().equals(ctx.getLanguage())).map(Map.Entry::getKey).collect(Collectors.toList());

            SalaryCotisationTable salaryTableContainer = new SalaryCotisationTable(localcodeElementHead.get(ctx.getRandom().nextInt(localcodeElementHead.size())),
                    localheadingHead.get(ctx.getRandom().nextInt(localheadingHead.size())),
                    localbaseHead.get(ctx.getRandom().nextInt(localbaseHead.size())),
                    localsalaryRateHead.get(ctx.getRandom().nextInt(localsalaryRateHead.size())),
                    localemployeeContrHead.get(ctx.getRandom().nextInt(localemployeeContrHead.size())),
                    localemployerRateHead.get(ctx.getRandom().nextInt(localemployerRateHead.size())),
                    localemployerContrHead.get(ctx.getRandom().nextInt(localemployerContrHead.size())));
           // composantes remun
            List<SalaryLine> composantesRemunLines = composantesRenum.get(ctx.getRandom().nextInt(composantesRenum.size()));
            for (int i= 0; i<composantesRemunLines.size(); i++){
                salaryTableContainer.addLineSalary(composantesRemunLines.get(i));
            }
            // santé
            List<SalaryLine> santeLines = santeCotisations.get(ctx.getRandom().nextInt(santeCotisations.size()));
            for (int i= 0; i<santeLines.size(); i++){
                salaryTableContainer.addLineSalary(santeLines.get(i));
            }
            // accident de travail
            List<SalaryLine> accidentLines = accidentCotisation.get(ctx.getRandom().nextInt(accidentCotisation.size()));
            for (int i= 0; i<accidentLines.size(); i++){
                salaryTableContainer.addLineSalary(accidentLines.get(i));
            }
            // Retraite
            List<SalaryLine> retraiteLines = retaraiteCotisation.get(ctx.getRandom().nextInt(retaraiteCotisation.size()));
            for (int i= 0; i<retraiteLines.size(); i++){
                salaryTableContainer.addLineSalary(retraiteLines.get(i));
            }
            // prestations familiales
            List<SalaryLine> prestationLines = prestationsCotisation.get(ctx.getRandom().nextInt(prestationsCotisation.size()));
            for (int i= 0; i<prestationLines.size(); i++){
                salaryTableContainer.addLineSalary(prestationLines.get(i));
            }
            // chomage
            List<SalaryLine> chomageLines = chomageCotisation.get(ctx.getRandom().nextInt(chomageCotisation.size()));
            for (int i= 0; i<chomageLines.size(); i++){
                salaryTableContainer.addLineSalary(chomageLines.get(i));
            }

            return salaryTableContainer;
        }

    }

}
