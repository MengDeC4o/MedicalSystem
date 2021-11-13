    @RequestMapping(value = "/patient_name_search")
    public Map<String,Object> patient_name_search(@RequestParam("patient_id")int patient_id)
    {
        Map<String,Object> map=new HashMap<>();
        Patient printed = patientMapper.selectByPatientId(patient_id);
        map.put("name",printed.getPatient_name());
        return map;
    }
